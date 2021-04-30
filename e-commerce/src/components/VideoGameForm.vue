<template>
  <div>
    <form @submit.prevent="saveVideoGame">
      <p>
        Nom :
        <input
          v-model="videoGame.name"
          type="text"
          required
        >
      </p><div v-if="errorMessage.name">
        {{ errorMessage.name }}
      </div>
      <p>
        Commentaires :
        <textarea v-model="videoGame.comment" />
      </p>
      <p>
        Prix HT :
        <input
          v-model="videoGame.priceHT"
          type="number"
          required
        >
      </p><div v-if="errorMessage.priceHT">
        {{ errorMessage.priceHT }}
      </div>
      <p>
        Prix TTC:
        <price-ttc
          v-model="videoGame.priceHT"
          :canEdit="true"
          @updatePriceHt="updatePriceHt"
        />
      </p>
      <p>
        Degré d'alcool :
        <input
          v-model="videoGame.alcoholDegree"
          type="number"
          min="0"
          max="70"
          step="any"
          required
        >
      </p><div v-if="errorMessage.alcoholDegree">
        {{ errorMessage.type }}
      </div>
      <p>
        <select
          v-model="videoGame.type"
          required
        >
          <option
            v-for="type in videoGameType"
            :key="type"
            :value="type"
          >
            {{ type }}
          </option>
        </select>
      </p><div v-if="errorMessage.type">
        {{ errorMessage.type }}
      </div>
      <button
        type="button"
        @click="goToList"
      >
        Annuler
      </button>
      <button
        type="submit"
        :disabled="!formIsValid"
      >
        Sauvegarder
      </button>
      <p v-if="genericError">
        Une erreur est survenue lors de la création ou de la modification d'un jeu vidéo.
      </p>
    </form>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import videoGamesApi from '../api/videoGamesApi';

export default {
  name: 'VideoGameForm',
  components: {},
  data() {
    return {
      genericError: false, // Erreur générique
      videoGame: { // Objet jeu vidéo
        id: 0, // Identifiant
        name: '', // Nom
        description: '', // Description
        price: 0, // Prix
        category: [], // Categories
        platform: [], // Plateformes
        developer: '', // Developeur
        release_date: '', // Date de sortie
        age: 0, // Age minimum requis
        note: 0, // Note du jeu
      },
      videoGameType: [ // Type d'un jeu vidéo possible
        "RPG",
        "FPS",
        "Action",
        "MMO",
        "Danse",
        "Aventure",
        "Tout"
      ],
      errorMessage: {}, // Objet de message d'erreur
      isUpdate: false // En modification
    };
  },
  computed: {
    formIsValid() { // Vérifie si le formulaire est valide
      return this.videoGame.name !== '' && this.videoGame.priceHT !== '' && this.videoGame.alcoholDegree !== '' && this.videoGame.type !== '';
    },
    ...mapGetters({
      currentVideoGame: "getCurrentVideoGame",
      owner: 'getOwner'
    })
  },
  methods: {
    goToList() { // Affiche la liste des jeux vidéos
      this.$store.commit('resetCurrentVideoGame');
      this.$router.push('/');
    },
    async saveVideoGame() { // Sauvegarde un jeu vidéo
      try {
        if (this.formIsValid) {
          if (this.isUpdate) {
            await videoGamesApi.updateVideoGame(this.videoGame, this.owner);
          } else {
            await videoGamesApi.createVideoGame(this.videoGame, this.owner);
          }
          this.goToList();
        } else {
          if (this.videoGame.name === '') {
            this.errorMessage.name = 'Le nom est obligatoire.';
          }
          if (this.videoGame.priceHT === '') {
            this.errorMessage.priceHT = 'Le prix est obligatoire.';
          }
          if (this.videoGame.type === '' || !this.videoGameType.includes(this.videoGame.type)) {
            this.errorMessage.type = 'Le type est obligatoire et doit être d\'une des valeurs suivantes BLONDE, BROWN, IPA, DARK';
          }
          if (this.videoGame.alcoholDegree === '' || this.videoGame.alcoholDegree < 0 || this.videoGame.alcoholDegree > 70) {
            this.errorMessage.type = 'Le degré d\'alcool est obligatoire et doit être compris entre 0 et 70';
          }
        }
      } catch (error) {
        this.genericError = true;
        console.error('Erreur lors de la création ou la modification d\'un jeu video');
      }
    },
    async getVideoGame(videoGameId) { // Donne un jeu vidéo par rapport à un id donné
      try {
        const response = await videoGamesApi.getVideoGame(videoGameId, this.owner);
        this.videoGame = response.body;
      } catch (error) {
        console.error('Impossible de récupérer le jeu video avec id =', videoGameId);
      }
    }
  },
  mounted() { // A chaque chargement de la page
    if (this.$route.params.id && this.$route.params.id !== '' && this.$route.params.id !== 0) {
      this.isUpdate = true;
      this.getVideoGame(this.$route.params.id);
    }
  }
};
</script>

<style scoped>

</style>
