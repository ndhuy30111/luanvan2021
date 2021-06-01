<template>
  <div class="d-flex justify-content-around">
    <b-button class="btn" type="submit">{{ text }} </b-button>
    <b-button class="btn" type="submit">
      <img :src="require('@/assets/facebook.png')" class="img" />Facebook
    </b-button>
  </div>
</template>

<script>
export default {
  props: ['text'],
}
</script>

<style lang="scss" scoped>
.btn {
  display: block;
  height: 38px;
  width: 50%;
  border-radius: 20px;
  outline: none;
  border: none;
  background: rgb(241, 16, 16);
  color: white;
  background-size: 200%;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  text-transform: uppercase;
  margin: 0.5rem 0;
  cursor: pointer;
  transition: 0.5s;
}
.btn:nth-child(2) {
  background: rgb(49, 96, 252);
  color: white;
  margin-left: 50px;
}
.img {
  width: 20px;
  height: 20px;
  margin: 5px;
}
@media screen and (max-width: 600px) {
  .btn {
    font-size: 10px;
  }
}
</style>
