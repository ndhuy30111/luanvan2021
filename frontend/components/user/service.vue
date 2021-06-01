<template>
  <v-row class="service">
    <v-col cols="4">
      <div class="box">
        <div class="center">
          <img :src="require(`~/assets/service/ship.jpg`)" alt="ship" />
          <p>Dịch vụ vận chuyển</p>
        </div>
      </div>
    </v-col>
    <v-col cols="4">
      <div class="box">
        <div class="center">
          <img :src="require(`~/assets/service/checkout.jpg`)" alt="ship" />
          <p>Chính sách thanh toán</p>
        </div>
      </div>
    </v-col>
    <v-col cols="4">
      <div class="box">
        <div class="center">
          <img :src="require(`~/assets/service/servies.jpg`)" alt="ship" />
          <p>Hỗ trợ khách hàng</p>
        </div>
      </div>
    </v-col>
  </v-row>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
.service {
  margin-top: 20px;
  .box {
    height: 150px;
    background-color: rgb(247, 247, 247);
    .center {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      font-size: 15px;
      padding: 10px;
      border-radius: 20px;
      cursor: pointer;
      img {
        margin-left: 30%;
        width: 50px;
      }
      p {
        font-size: 17px;
        font-weight: bold;
      }
    }
  }
}
@media screen and (max-width: 600px) {
  .service {
    .box {
      .center {
        img {
          margin-left: 20%;
          width: 20px;
        }
        p {
          font-size: 10px;
          font-weight: bold;
        }
      }
    }
  }
}
</style>
