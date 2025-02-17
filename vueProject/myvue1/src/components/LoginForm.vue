<template>
    <div class="login-form">
      <form @submit.prevent="Login">
        <div class="form-group">
          <h1 id="logintitle">로그인</h1>
          <label for="username">사용자 이름</label>
          <input
            type="text"
            id="username"
            v-model="username"
            placeholder="사용자 이름을 입력하세요"
            required
          />
        </div>
  
        <div class="form-group">
          <label for="password">비밀번호</label>
          <input
            type="password"
            id="password"
            v-model="password"
            placeholder="비밀번호를 입력하세요"
            required
          />
        </div>
  
        <button type="submit">로그인</button>
      </form>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <router-link to="/register" class="text-blue-500 mt-4" id="register">회원가입</router-link>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'LoginForm',
    data() {
      return {
        username: '',
        password: '',
        errorMessage: '',
      };
    },
    methods: {
      async Login() {
        try{
          const response = await axios.post("http://localhost:8080/api/auth/login",{
            username: this.username,
            password: this.password
          });
          const token = response.data.token;
          localStorage.setItem("jwt",token);

          window.location.href = "http://localhost:8080/api/auth/success";

        } catch (err)
        {
          this.errorMessage = "Invalid username or password";
        }
      },
    },
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
input{
    background-color: transparent;
}
  .login-form {
    max-width: 800px;
    margin: 100px 100px 100px 100px;
  text-align: left;
  padding: 60px; /* 내부 여백 */
  border-radius: 8px; /* 테두리 둥글게 */
  border: 2px solid black;
  }
  
  .form-group {
    margin-bottom: 15px;
    padding: 5px;

  }
    .form-group input {
  margin: 5px;
  padding: 0 1em; 
  border-bottom: 1px solid rgb(112, 108, 108);;
  height: 38px;
  width: 100%;
    
  }
  
 .login-form button{
  margin-top: 20px;
  border: 1px solid rgb(112, 108, 108);;
  border-radius: 10px;
 }

  label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
  }
  
  input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
  }
  
  button {
    width: 100%;
    margin-bottom: 20px;
    padding: 10px;
    background-color: blue;
    border: 2px solid black;
    color: blue;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #45a049;
  }
  
  .error {
    color: red;
    margin-top: 10px;
  }

  #logintitle
  {
    margin: 20px;
  }

  #register {
    margin-left: auto;
  }

  </style>
  