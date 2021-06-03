<template>
  <b-container>
    <b-row>
      <b-col cols="12" sm="6" md="8">
        <image-magnifier
          class="img"
          :src="require('@/assets/product/vay1.jpg')"
          :zoom-src="require('@/assets/product/vay1.jpg')"
          alt="img product"
          width="100%"
          height="100%"
          zoom-width="400"
          zoom-height="300"
        />
      </b-col>

      <b-col cols="12" sm="6" md="4">
        <div class="wrapper">
          <div class="outer">
            <div class="content">
              <span class="product__content">Tên sp</span>

              <div class="colors-wrap">
                <h5>Màu sắc:</h5>
                <span class="colors" style="background-color: red"></span>
                <span
                  class="colors selected"
                  style="background-color: black"
                ></span>
                <span class="colors" style="background-color: blue"></span>
              </div>

              <div class="size-wrap">
                <h5>Kích cỡ:</h5>
                <span class="size selected">S</span>
                <span class="size">M</span>
              </div>
              <div class="size-wrap">
                <h5>Số lượng:</h5>
                <b-form-input
                  id="input-amount"
                  v-model="quantity"
                  type="number"
                  min="1"
                  style="width: 70px; margin-left: 20px"
                  >{{ quantity }}</b-form-input
                >
              </div>

              <div class="button">
                <span>
                  <a href="#"> 10000000 đ</a>
                  <a class="cart-btn">
                    <b-icon icon="cart"></b-icon> Thêm vào giỏ</a
                  >
                </span>
              </div>
            </div>
          </div>
        </div>
      </b-col>
    </b-row>
    <b-row class="opinion">
      <Opinion></Opinion>
    </b-row>
    <b-row>
      <b-col>
        <Listproduct :menutab="$local.vn.same_product" />
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import Opinion from '~/components/user/opinion'
import Listproduct from '~/components/user/ListProduct'
export default {
  name: 'Productdetail',
  components: { Opinion, Listproduct },
  data() {
    return {
      quantity: 1,
    }
  },
}
</script>

<style scoped>
.wrapper {
  display: flex;
  align-items: center;
  justify-content: space-around;
  width: 100%;
  margin-top: 20px;
}
p {
  width: 280px;
  font-size: 13px;
  line-height: 1.4;
  color: #aaa;
  margin: 20px 0;
}
.img {
  top: 0px;
  right: 0px;
  width: 80%;
  margin-top: -15px;
  height: 70%;
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
}
.content {
  position: relative;
  z-index: 3;
  margin-top: -20%;
  text-align: left;
}
.bg {
  display: inline-block;
  overflow: hidden;
  position: relative;
  font-size: 15px;

  color: #fff;
  background-color: red;
  text-decoration: none;
  padding: 10px 10px;
  border: 1px solid #aaa;
  font-weight: bold;
  border-radius: 25px;
}
.button {
  width: fit-content;
  height: fit-content;
  margin-top: 10px;
}
.button a {
  display: inline-block;
  overflow: hidden;
  position: relative;
  font-size: 15px;
  color: #111;
  text-decoration: none;
  padding: 10px 10px;
  border: 1px solid #aaa;
  font-weight: bold;
}
.button a:after {
  content: '';
  position: absolute;
  top: 0;
  right: -10px;
  width: 0%;
  background-color: #111;
  height: 100%;
  z-index: -1;
  transition: width 0.3s ease-in-out;
  transform: skew(-25deg);
  transform-origin: right;
}
.product__content {
  font-size: 2.5em;
}
.button a:hover:after {
  width: 150%;
  left: -10px;
  transform-origin: left;
}
.button a:hover {
  color: #fff;
  transition: all 0.5s ease;
}
.button a:nth-of-type(1) {
  border-radius: 50px 0 0 50px;
  border-right: none;
}
.button a:nth-of-type(2) {
  border-radius: 0px 50px 50px 0;
}
.cart-icon {
  padding-right: 8px;
}
.colors {
  width: 20px;
  height: 20px;
  display: inline-block;
  transition: 0.3s all;
  border-radius: 50%;
  border: 1px solid black;
  margin: 0 15px;
}
.colors:hover,
.size:hover {
  transform: scale(1.2);
  box-shadow: 0 0 0 8px rgba(173, 173, 170, 0.3);
  cursor: pointer;
}
.colors:active,
.size:active {
  transform: scale(0.8);
}
.selected {
  box-shadow: 0 0 0 4px #fff, 0 0 0 8px rgba(173, 173, 170, 0.3);
}
.colors-wrap,
.size-wrap {
  width: 100%;
  height: auto;
  margin: 5px auto;
  padding: 10px;
  border-radius: 70px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.size {
  border-radius: 50%;
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 15px;
  cursor: pointer;
  transition: all 0.3s;
}
.sameproduct {
  margin-top: -10%;
}
.opinion {
  margin-top: -20%;
}
@media (max-width: 700px) {
  .wrapper {
    margin: -100px 0px 0px -35px;
  }
  .outer {
    width: 95%;
    margin-top: 0;
  }
  .content {
    left: 50%;
    transform: translateX(-40%);
  }

  .img {
    /* display: none; */
    width: 100%;
    margin-top: 0px !important;
  }
  .product__content {
    font-size: 2em;
  }
  .opinion {
    margin-top: 10px;
  }
}
</style>
