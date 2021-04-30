<template>
  <div>
    <div
      v-if="list"
    >
      <select
        v-model="choice"
        required
      >
        <option
          v-for="category in videoGameCategory"
          :key="category"
          :value="category"
        >
          {{ category }}
        </option>
      </select>
      <input
        class="form-control"
        type="text"
        v-model="searchQuery" placeholder="Search"
      >
      <button>
        Rechercher
      </button>
      <table>
        <th id="th1">Nom</th>
        <th id="th2">Description</th>
        <th id="th3">Prix</th>
        <th id="th4">Genre</th>
        <th id="th5">Plateforme</th>
        <th id="th6">Développeur</th>
        <th id="th7">Date de Sortie</th>
        <th id="th8">Age</th>
        <th id="th9">Note</th>
        <th id="th10">Option</th>
      </table>
      <table>
        <tr
          v-for="(videoGame, id) in resultQuery"
          :key="id"
        >
          <td>
            <table>
              <tr
                v-for="(category, num) in videoGame.category"
                :key="num"
              >
                <td>
                  <table
                    id="ta1"
                    v-if="category === choice"
                  >
                    <tr>
                      <td id="td1">
                        {{ videoGame.name }}
                      </td>
                      <td id="td2">
                        {{ videoGame.description }}
                      </td>
                      <td id="td3">
                        {{ videoGame.price }} Euros
                      </td>
                      <td id="td4">
                        <table id="ta4">
                          <tr
                            v-for="(category, index) in videoGame.category"
                            :key="index"
                          >
                            <td
                              v-if="category !== 'Tout'"
                            >
                              {{ category }}
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td id="td5">
                        <table id="ta5">
                          <tr
                            v-for="(platform, index) in videoGame.platform"
                            :key="index"
                          >
                            <td>
                              {{ platform }}
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td id="td6">
                        {{ videoGame.developer }}
                      </td>
                      <td id="td7">
                        {{ videoGame.release_date }}
                      </td>
                      <td id="td8">
                        {{ videoGame.age }}
                      </td>
                      <td id="td9">
                        {{ videoGame.note }}
                      </td>
                      <td id="td10">
                        <button
                          type="button"
                          @click="payVideoGame(videoGame)"
                        >
                          Acheter
                        </button>
                        <br>
                        <div v-for="(game, g) in clients[idClient].video_games"
                             :key="g">
                          <button
                            v-if="game === videoGame.name"
                            type="button"
                            @click="refundVideoGame(videoGame)"
                          >
                            Remboursement
                          </button>
                        </div>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>
    <div v-if="payment">
      <button
        type="button"
        @click="listVideoGame()"
      >
        Liste de Jeux Vidéos
      </button>
      <video-game-pay
        :idVideoGame="idVideoGame"
        :idClient="idClient"
      />
    </div>
    <div v-if="repayment">
      <button
        type="button"
        @click="listVideoGame()"
      >
        Liste de Jeux Vidéos
      </button>
      <video-game-refund
        :idVideoGame="idVideoGame"
        :idClient="idClient"
      />
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import videoGamesData from "../videogames.json";
import clientsData from "../clients.json";
import VideoGamePay from './VideoGamePay';
import VideoGameRefund from './VideoGameRefund';
export default {
  name: 'videoGameList',
  components: {
    VideoGamePay,
    VideoGameRefund
  },
  props: {
    idClient: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      videoGames: videoGamesData,
      clients: clientsData,
      videoGameCategory: [
        "Tout",
        "Action",
        "MMO",
        "FPS",
        "Aventure",
        "RPG",
        "Sport",
        "Stratégie",
        "Jeu de cartes"
      ],
      searchQuery: null,
      choice: 'Tout',
      payment: false,
      repayment: false,
      list: true,
      idVideoGame: '0'
    };
  },
  computed: {
    ...mapMutations({
      setCurrentVideoGame: "setCurrentVideoGame",
      owner: "setOwner"
    }),
    resultQuery() { // Fonction qui recherche un jeu vidéo
      if (this.searchQuery) {
        return this.videoGames.filter((item) => {
          return this.searchQuery.toLowerCase().split(' ').every(v => item.name.toLowerCase().includes(v));
        });
      } else {
        return this.videoGames;
      }
    }
  },
  methods: {
    payVideoGame(videoGame) { // Fonction qui affiche le paiement d'un jeu vidéo
      this.idVideoGame = videoGame.id;
      this.payment = true;
      this.repayment = false;
      this.list = false;
    },
    refundVideoGame(videoGame) { // Fonction qui affiche le remboursement d'un jeu vidéo
      this.idVideoGame = videoGame.id;
      this.payment = false;
      this.repayment = true;
      this.list = false;
    },
    listVideoGame(videoGame) { // Fonction qui va afficher la liste des jeux vidéos
      this.idVideoGame = 0;
      this.payment = false;
      this.repayment = false;
      this.list = true;
    }
  }
};
</script>

<style scoped>
table {
  width: 100%;
}
table, th, td {
  text-align: center;
}
#th1, #td1 {
  width: 10%;
}
#th2,#td2 {
  width: 28%;
}
#th3,#td3 {
  width: 10%;
}
#th4,#td4 {
  width: 8%;
}
#ta4 {
  width: 100%;
}
#th5,#td5 {
  width: 6%;
}
#ta5 {
  width: 100%;
}
#th6,#td6 {
  width: 10%;
}
#th7,#td7 {
  width: 10%;
}
#th8,#td8 {
  width: 4%;
}
#th9, #td9 {
  width: 4%;
}
#th10, #td10 {
  width: 10%;
}
</style>
