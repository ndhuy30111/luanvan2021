<template>
  <div>
    <div>
      <b-carousel
        id="carousel"
        style="text-shadow: 0px 0px 2px #000"
        :interval="4000"
        fade
        indicators
        img-width="1024"
        img-height="450"
      >
        <b-carousel-slide
          id="content-index"
          img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-2-1_x1024.jpg?v=1516243763"
        >
          <div class="content">
            <h6>Bright-Light Outerwear</h6>
            <b-button variant="dark">SHOPPING NOW</b-button>
          </div>
        </b-carousel-slide>
        <b-carousel-slide
          img-src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-2-3_x1024.jpg?v=1516245583"
        >
          <div class="content">
            <h6>Frilled Sleeve Top</h6>
            <b-button variant="dark">SHOPPING NOW</b-button>
          </div>
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
  margin-bottom: 20px;
  margin-top: -30px;
  .content {
    width: 50%;
    margin-top: -25%;
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
      background: black;
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
