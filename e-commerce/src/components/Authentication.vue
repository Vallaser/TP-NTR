<template>
  <div>
    <div
      v-if="authentication"
    >
      <h1>
        Authentification
      </h1>
      <p>
        E-mail :
        <input
          v-model="form.email"
          type="text"
          required
        >
      </p>
      <p>
        Mot de Passe :
        <input
          v-model="form.password"
          type="text"
          required
        >
      </p>
      <div v-if="errorMessage.all">
        {{ errorMessage.all }}
      </div>
      <br>
      <button
        type="button"
        @click="connectionClient(client)"
      >
        Se Connecter
      </button>
      <button
        type="button"
        @click="registrationClient(client)"
      >
        S'Inscire
      </button>
      <br>
    </div>
    <div
      v-if="list"
    >
      <h1>
        Bienvenue {{ client.firstname }}
      </h1>
      <br>
      <button
        type="button"
        @click="disconnectionClient(client)"
      >
        Se Déconnecter
      </button>
      <br><br>
      <header-video-game
        :idClient="client.id-1"
      />
    </div>
    <div
      v-if="registration"
    >
      <button
        type="button"
        @click="back()"
      >
        Retour
      </button>
      <registration/>
    </div>
  </div>
</template>

<script>
import clientsData from "../clients.json";
import HeaderVideoGame from './HeaderVideoGame';
import Registration from './Registration';
export default {
  name: "Authentication.vue",
  components: {
    HeaderVideoGame,
    Registration
  },
  data() {
    return {
      clients: clientsData, // Liste des clients
      client: { // Objet client
        id: 0, // Identifiant
        surname: '', // Nom de famille
        firstname: '', // Prénom
        email: '', // E-mail
        password: '' // Mot de Passe
      },
      form: { // Objet formulaire
        email: '', // E-mail
        password: '' // Mot de Passe
      },
      errorMessage: { // Objet message d'erreur
        all: '' // Tout
      },
      authentication: true, // La balise authentification est visible ?
      registration: false, // La balise registration est visible ?
      list: false // La balise list est visible ?
    };
  },
  computed: {
    formIsValid() { // Fonction qui vérifie si le formulaire de connexion est correct
      let valid = false;
      this.clients.forEach((client, index) => {
        if (client.email === this.form.email && client.password === this.form.password) {
          this.client.id = client.id;
          this.client.email = client.email;
          this.client.surname = client.surname;
          this.client.firstname = client.firstname;
          valid = true;
        }
      });
      return valid;
    }
  },
  methods: {
    connectionClient() { // Fonction qui va essayé de vous connecter
      try {
        if (this.formIsValid) {
          alert('Connexion réussie');
          this.authentication = false;
          this.list = true;
          this.registration = false;
        } else {
          this.errorMessage.all = 'Les informations ne sont pas bonnes.';
        }
      } catch (error) {
        this.genericError = true;
        console.error('Erreur lors de la connexion');
      }
    },
    disconnectionClient() { // Fonction qui va déconnecter le client en cours.
      try {
        alert('Déconnexion réussie');
        this.authentication = true;
        this.list = false;
        this.registration = false;
      } catch (error) {
        this.genericError = true;
        console.error('Erreur lors de la deconnexion');
      }
    },
    registrationClient() { // Fonction qui va afficher le formulaire d'inscription
      this.authentication = false;
      this.registration = true;
      this.list = false;
    },
    back() { // Fonction qui va réafficher le formulaire de connexion
      this.authentication = true;
      this.registration = false;
      this.list = false;
    }
  },
  mounted() {
  }
};
</script>

<style scoped>

</style>
