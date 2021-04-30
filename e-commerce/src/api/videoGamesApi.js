import Vue from 'vue';
const BASE_URL = 'https://spring.io/guides/gs-producing-web-service';

export default {
  getVideoGame(videoGameId, owner) {
    return Vue.http.get(`${BASE_URL}/${videoGameId}`, {
      params: {
        owner
      }
    });
  },
  getAllVideoGames(owner) {
    return Vue.http.get(`${BASE_URL}`, {
      params: {
        owner
      }
    });
  },
  createVideoGame(videoGame, owner) {
    return Vue.http.post(`${BASE_URL}?owner=${owner}`, {
      ...videoGame
    });
  },
  updateVideoGame(videoGame, owner) {
    return Vue.http.put(`${BASE_URL}/${videoGame.id}?owner=${owner}`, {
      ...videoGame,
      owner
    });
  },
  removeVideoGame(videoGameId, owner) {
    return Vue.http.delete(`${BASE_URL}/${videoGameId}?owner=${owner}`);
  }
};
