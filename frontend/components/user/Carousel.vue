<template>
  <div>
    <div>
      <b-carousel
        id="carousel"
        style="text-shadow: 0px 0px 2px #000"
        :interval="1200"
        fade
        indicators
        img-width="1024"
        img-height="450"
      >
        <b-carousel-slide
          id="content-index"
          :img-src="require(`~/assets//category/banner3.jpg`)"
        >
        </b-carousel-slide>
        <b-carousel-slide :img-src="require(`~/assets//category/banner1.jpg`)">
        </b-carousel-slide>
      </b-carousel>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
#carousel {
  margin-top: -7%;
}
@media screen and (max-width: 900px) {
  #carousel {
    margin-top: -5%;
  }
}
</style>
