import './assets/main.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(createPinia());
app.use(router);

window.Kakao.init('01e29eb290f0e68687fc4a185ae328a9'); // 사용하려는 앱의 JavaScript 키 입력

app.mount('#app');
