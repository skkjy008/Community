import { createRouter, createWebHistory } from 'vue-router'
import BoardList from '@/components/BoardList.vue';
import BoardDetail from '@/components/BoardDetail.vue';
import CreateBoard from '@/components/CreateBoard.vue';

const routes = [

  { path: "/", component: BoardList },
  { path: "/create", component: CreateBoard },
  { path: "/boards/:id", component: BoardDetail },

]

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router
