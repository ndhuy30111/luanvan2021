<template>
  <div>
    <b-button id="btn" type="submit">{{ text }} </b-button>
  </div>
</template>

<script>
export default {
  props: ['text'],
}
</script>

<style lang="scss" scoped>
#btn {
  display: block;
  height: 40px;
  border-radius: 25px;
  outline: none;
  border: none;
  background-image: linear-gradient(to right, #ce785c, #c4826c, #ec997e);
  background-size: 200%;
  color: rgb(255, 255, 255);
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  text-transform: uppercase;
  margin: 0.5rem 0;
  cursor: pointer;
  transition: 0.5s;
}
@media screen and (max-width: 600px) {
  .btn {
    font-size: 10px;
  }
}
</style>
