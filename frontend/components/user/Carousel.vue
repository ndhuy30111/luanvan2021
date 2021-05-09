<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="5000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        id="content-index"
        img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-1-3_x1024.jpg?v=1515578976"
      >
        <div class="content hahaha" id="content-2">
          <h1>Luxury Handbags</h1>
          <p>Discount every in orders</p>
          <b-button variant="dark">SHOPPING NOW</b-button>
        </div>
      </b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide
        img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-1-2_x1024.jpg?v=1515579141"
      >
        <div class="content">
          <h1>Frilled Sleeve Top</h1>
          <p>Discount every in orders</p>
          <b-button variant="dark">SHOPPING NOW</b-button>
        </div>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/slider-1_x1024.jpg?v=1513869131"
      >
        <div class="content">
          <h1>Frilled Sleeve Top</h1>
          <p>Stock in physical stores</p>
          <b-button variant="dark">SHOPPING NOW</b-button>
        </div>
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
    }
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    },
  },
}
</script>

<style lang="scss" scoped>
.content {
  width: 50%;
  margin: 25%;
  color: black;
  animation-name: example;
  animation-duration: 2.5s;
  animation-fill-mode: forwards;
}
.content h1 {
  font-size: 3em;
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}
.content p {
  margin-bottom: 4%;
}
.btn-dark {
  color: white;
  border-radius: 38px;
  padding: 10px;
  font-size: 12px;
}
@keyframes example {
  from {
    left: 0px;
  }
  to {
    left: 300px;
  }
}
</style>
