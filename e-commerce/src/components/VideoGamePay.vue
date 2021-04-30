<template>
  <div>
    <div id="app">
      {{ info }}
    </div>
    <form @submit.prevent="payVideoGame">
      <a
        v-for="(videoGame, id) in videoGames"
        :key="id">
        <table
          v-if="videoGame.id === idVideoGame"
        >
          <tr>
            <td>Nom :</td>
            <td>{{ videoGame.name }}</td>
          </tr>
          <tr>
            <td>Description :</td>
            <td>{{ videoGame.description }}</td>
          </tr>
          <tr>
            <td>Prix :</td>
            <td>
              {{ videoGame.price }}
            </td>
          </tr>
          <tr>
            <td>Genre :</td>
            <td>
              <p
                v-for="(category, index) in videoGame.category"
                :key="index"
              >
                <a
                  v-if="category !== 'Tout'"
                >
                  {{ category }}
                </a>
              </p>
            </td>
          </tr>
          <tr>
            <td>Plateforme :</td>
            <td>
              <p
                v-for="(platform, index) in videoGame.platform"
                :key="index"
              >
                {{ platform }}
              </p>
            </td>
          </tr>
          <tr>
            <td>Développeur :</td>
            <td>{{ videoGame.developer }}</td>
          </tr>
          <tr>
            <td>Date de Sortie :</td>
            <td>{{ videoGame.release_date }}</td>
          </tr>
          <tr>
            <td>Age :</td>
            <td>{{ videoGame.age }}</td>
          </tr>
          <tr>
            <td>Note :</td>
            <td>{{ videoGame.note }}</td>
          </tr>
          <br>
          <tr>
            <td colspan="2">
              <button
                type="button"
                @click="payVideoGame(videoGame)"
              >
                Payer
              </button>
            </td>
          </tr>
        </table>
      </a>
    </form>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
// Import videoGamesApi from '../api/videoGamesApi';
import videoGamesData from "../videogames.json";
import axios from 'axios';
import Vue from "vue";
Vue.use(axios);
export default {
  name: 'VideoGamePay',
  components: { },
  props: {
    idClient: {
      type: Number,
      required: true
    },
    idVideoGame: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      genericError: false,
      videoGames: videoGamesData,
      url_id: this.$route.params.id,
      form: {
        email: '',
        price: 0,
        date: '',
        op: '+'
      },
      errorMessage: {
        email: ''
      },
      info: null
    };
  },
  computed: {
    formIsValid() {
      return this.form.email !== '';
    },
    ...mapGetters({
      getCurrentVideoGame: "getCurrentVideoGame",
      owner: 'getOwner'
    })
  },
  methods: {
    goToList() { // Fonction qui raffiche la liste
      this.$store.commit('resetCurrentVideoGame');
      this.$router.push('/');
    },
    getDate (videoGame) { // Fonction qui récupère la date d'achat
      const date = new Date();
      this.form.date = date.getDate();
      this.form.date += '/';
      if (date.getMonth() + 1 < 9) {
        this.form.date += '0';
      }
      this.form.date += date.getMonth() + 1;
      this.form.date += '/';
      this.form.date += date.getFullYear();
      this.form.date += ' ';
      if (date.getHours() < 10) {
        this.form.date += '0';
      }
      this.form.date += date.getHours();
      this.form.date += ':';
      if (date.getMinutes() < 10) {
        this.form.date += '0';
      }
      this.form.date += date.getMinutes();
      this.form.date += ':';
      if (date.getSeconds() < 10) {
        this.form.date += '0';
      }
      this.form.date += date.getSeconds();
      this.form.price = videoGame.price;
    },
    payVideoGame(videoGame) { // Fonction qui paie un jeu vidéo
      try {
        this.getDate(videoGame);
        alert('test');
        axios
          .get('http://localhost:8080/ExempleWebAppMaven/myfirsts/')
          .then(response => (this.info = response))
          .catch(error => {
            console.log(error);
          });
      } catch (error) {
        this.genericError = true;
        console.error('Erreur lors de l\'achat d\'un jeu');
      }
    }
  }
};
</script>

<style scoped>
a,table {
  width : 100%;
}
td {
  text-align : center;
  width : 50%;
}
</style>
