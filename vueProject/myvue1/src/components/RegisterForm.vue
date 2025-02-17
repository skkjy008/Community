<template>
    <div class="flex flex-col items-center justify-center min-h-screen" id="registerForm">
      <h1 class="text-2xl font-bold mb-4">회원가입</h1>
      <input v-model="username" type="text" placeholder="Username" class="border p-2 mb-2 w-64 rounded" />
      <input v-model="nickname" type="text" placeholder="Nickname" class="border p-2 mb-2 w-64 rounded" />
      <input v-model="email" type="email" placeholder="Email" class="border p-2 mb-2 w-64 rounded" />
      <input v-model="password" type="password" placeholder="Password" class="border p-2 mb-2 w-64 rounded" />
      <button @click="register" class="bg-green-500 text-black px-4 py-2 rounded" id="regbtn">회원가입</button>
      <p v-if="errorMessage" class="text-red-500 mt-2">{{ errorMessage }}</p>
      <router-link to="/" class="text-blue-500 mt-4">로그인으로 돌아가기</router-link>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'RegisterForm',
    data() {
      return {
        username: '',
        nickname: '',
        email: '',
        password: '',
        errorMessage: ''
      };
    },
    methods: {
      async register() {
        try {
          await axios.post('http://localhost:8080/api/auth/register', {
            username: this.username,
            nickname: this.nickname,
            email: this.email,
            password: this.password

          });
          this.$router.push('/');
        } catch (err) {
          this.errorMessage = 'Registration failed. Please try again.';
        }
      }
    }
  };
  </script>

  <style>
  body {
  display: flex; /* Flexbox 활성화 */
  justify-content: center; /* 가로 방향 중앙 정렬 */
  align-items: center; /* 세로 방향 중앙 정렬 */
  height: 100vh; /* 화면 전체 높이 사용 */
  margin: 0; /* 기본 여백 제거 */
}

#registerForm
{
    max-width: 500px;
    margin: 0 auto;
    text-align: left;
  padding: 20px; /* 내부 여백 */
  border-radius: 8px; /* 테두리 둥글게 */
  border: 1px solid black;
}

#regbtn
{
    border: 1px solid black;
    color: black;

    
}

</style>