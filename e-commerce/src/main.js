import Vue from 'vue';
import App from './App.vue';

import VueResource from 'vue-resource';

import router from './router';
import store from './store';
// Import upperCaseFilter from './utils/filter';
Vue.config.productionTip = false;
Vue.use(VueResource);
// Add filter to Vue instance
// Vue.filter('upperCaseFilter', upperCaseFilter);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
