import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import VideoGamePay from '../components/VideoGamePay';
import VideoGameList from '../components/VideoGameList';
import Authentication from '../components/Authentication';
import VueResource from "vue-resource";

Vue.use(VueRouter);
Vue.use(VueResource);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [
      {
        path: '/',
        name: 'Authentication',
        component: Authentication
      },
      {
        path: '12',
        name: 'VideoGameList',
        component: VideoGameList
      },
      {
        path: '/pay/:id',
        name: 'VideoGamePay',
        component: VideoGamePay
      }
    ]
  },
  {
    path: '*',
    redirect: '/'
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
