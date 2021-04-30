import Vue from 'vue';
import Vuex from 'vuex';

import axios from 'axios';

Vue.use(axios);
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    owner: 'valerianB',
    videoGames: [],
    currentVideoGame: null
  },
  mutations: {
    setOwner(state, owner) {
      state.owner = owner;
    },
    addVideoGame(state, videoGame) {
      state.videoGames.push(videoGame);
    },
    setCurrentVideoGame(state, videoGame) {
      state.currentVideoGame = videoGame;
    },
    updateVideoGame(state, videoGame) {
      let beerToUpdate = state.videoGames.find(item => item.id === videoGame.id);
      if (beerToUpdate) {
        beerToUpdate = videoGame;
      }
    },
    resetCurrentBeer(state) {
      state.currentBeer = null;
    }
  },
  getters: {
    getOwner(state) {
      return state.owner;
    },
    getAllVideoGames(state) {
      return state.videoGames;
    },
    getCurrentVideoGame(state) {
      return state.currentVideoGame;
    }
  }
});
