<template>
  <div>
    <h1>
      Inscription
    </h1>
    <p>
      Nom :
      <input
        v-model="form.surname"
        type="text"
        required
      >
    </p>
    <div v-if="errorMessage.surname">
      {{ errorMessage.surname }}
    </div>
    <p>
      Prénom :
      <input
        v-model="form.firstname"
        type="text"
        required
      >
    </p>
    <div v-if="errorMessage.firstname">
      {{ errorMessage.firstname }}
    </div>
    <p>
      Age :
      <input
        v-model="form.age"
        type="number"
        required
      >
    </p>
    <div v-if="errorMessage.age">
      {{ errorMessage.age }}
    </div>
    <p>
      E-mail:
      <input
        v-model="form.email"
        type="text"
        required
      >
    </p>
    <div v-if="errorMessage.email">
      {{ errorMessage.email }}
    </div>
    <p>
      Password :
      <input
        v-model="form.password"
        type="text"
        required
      >
    </p>
    <div v-if="errorMessage.password">
      {{ errorMessage.password }}
    </div>
    <button
      type="button"
      @click="registrationClient()"
    >
      S'Inscire
    </button>
  </div>
</template>

<script>
import clientsData from "../clients.json";
export default {
  name: "Registration.vue",
  data() {
    return {
      clients: clientsData, // Liste de clients
      client: { // Objet de client
        id: 0,
        surname: '',
        firstname: '',
        email: '',
        password: ''
      },
      form: { // Objet de formulaire
        id: 0,
        surname: '',
        firstname: '',
        age: 0,
        email: '',
        password: '',
        video_games: [
        ]
      },
      errorMessage: { // Objet de message d'erreur
        surname: '',
        firstname: '',
        age: 0,
        email: '',
        password: ''
      }
    };
  },
  computed: {
    formIsValid() { // Fonction qui vériridie le formulaire
      return this.form.surname !== '' && this.form.firstname !== '' && this.form.age >= 0 && this.form.age !== '' && this.form.email !== '' && this.form.password !== '';
    }
  },
  methods: {
    registrationClient() { // Fonction qui permet d'enregistrer un client
      try {
        if (this.formIsValid) {
          this.clients.forEach((client, index) => {
            this.form.id += client.id;
            alert(client.id);
          });
        } else {
          if (this.form.surname === '') {
            this.errorMessage.surname = 'Le champ Nom ne peut pas être vide.';
          }
          if (this.form.firstname === '') {
            this.errorMessage.firstname = 'Le champ Prénom ne peut pas être vide.';
          }
          if (this.form.age < 0) {
            this.errorMessage.age = 'Le champ Age ne peut pas être négatif.';
          }
          if (this.form.age === '') {
            this.errorMessage.age = 'Le champ Age ne peut pas être vide.';
          }
          if (this.form.email === '') {
            this.errorMessage.email = 'Le champ E-mail ne peut pas être vide.';
          }
          if (this.form.password === '') {
            this.errorMessage.password = 'Le champ Mot de Passe ne peut pas être vide.';
          }
        }
      } catch (error) {
        this.genericError = true;
        console.error('Erreur lors de l\'inscription');
      }
    }
  }
};
</script>

<style scoped>

</style>
