import { createRouter, createWebHistory } from 'vue-router'
import BoardDetail from '@/components/BoardDetail.vue';
import CreateBoard from '@/components/CreateBoard.vue';
import RegisterForm from '@/components/RegisterForm.vue';
import LoginForm from '@/components/LoginForm.vue';

const routes = [

  { path: "/", name: 'Login', component: LoginForm },
  { path: "/create", component: CreateBoard },
  { path: "/boards/:id", component: BoardDetail },
  { path: "/register", name: 'Register', component: RegisterForm }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router
