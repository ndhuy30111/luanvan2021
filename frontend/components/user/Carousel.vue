<template>
  <div>
    <b-carousel
      id="carousel"
      v-model="slide"
      :interval="4000"
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
        <div class="content">
          <h6>Luxury Handbags</h6>
          <b-button variant="dark">SHOPPING NOW</b-button>
        </div>
      </b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide
        img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-1-2_x1024.jpg?v=1515579141"
      >
        <div class="content">
          <h6>Frilled Sleeve Top</h6>
          <b-button variant="dark">SHOPPING NOW</b-button>
        </div>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/slider-1_x1024.jpg?v=1513869131"
      >
        <div class="content">
          <h6>Frilled Sleeve Top</h6>
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
#carousel {
  margin-bottom: 20px;
  margin-top: -10px;
  .content {
    width: 50%;
    margin-top: -40%;
    color: black;
    position: relative;
    animation-name: example;
    animation-duration: 2s;
    animation-fill-mode: forwards;
    h6 {
      font-size: 3em;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin-bottom: 4%;
    }
    .btn-dark {
      color: white;
      border-radius: 38px;
      padding: 10px;
      font-size: 12px;
      border: none;
      background-image: linear-gradient(to right, #ce785c, #c4826c, #ec997e);
    }
    @keyframes example {
      from {
        left: 0px;
      }
      to {
        left: 180px;
      }
    }
  }
}
@media screen and (max-width: 600px) {
  #carousel .content h6 {
    font-size: 15px;
    margin-bottom: 2%;
  }
  #carousel .content .btn-dark {
    padding: 5px;
    font-size: 6px;
  }
  @keyframes example {
    from {
      left: 0px;
    }
    to {
      left: 65px;
    }
  }
}
</style>
