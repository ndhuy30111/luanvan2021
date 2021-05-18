<template>
  <div class="row">
    <div class="column">
      <a href="/">
        <img
          src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-8.jpg?v=1517147164"
        />
      </a>
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-5-1_x1024.jpg?v=1516415972"
      />
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-11-1_x1024.jpg?v=1516937812"
      />
    </div>
    <div class="column">
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/home-10-3_x1024.jpg?v=1516765879"
      />
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/screenshot-nouthemes.co-2018-01-25-14-07-17-817.png?v=1516864107"
      />
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/screenshot-nouthemes.co-2018-01-25-14-07-30-482.png?v=1516864117"
      />
    </div>
    <div class="column">
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/banner-4_x1024.jpg?v=1517058951"
      />
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-1_1.jpg?v=1517146849"
      />
      <img
        src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-1_c835a71f-82f1-4e07-a10f-0f4faeb81280.jpg?v=1516597137"
      />
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
.row {
  display: flex;
  flex-wrap: wrap;
  padding: 0 4px;
  .column {
    flex: 25%;
    max-width: 33.3%;
    padding: 0 4px;
    img {
      margin-top: 8px;
      vertical-align: middle;
      width: 100%;
      filter: grayscale(0.5) brightness(0.5);
      border-radius: 5px;
      cursor: pointer;
      transition: 0.3s linear;
    }
  }
  .column img:hover {
    filter: grayscale(0);
  }
}

@media screen and (max-width: 800px) {
  .column {
    flex: 50%;
    max-width: 50%;
  }
}
@media screen and (max-width: 600px) {
  .column {
    flex: 100%;
    max-width: 100%;
    img {
      filter: grayscale(0) brightness(1);
    }
  }
}
</style>
