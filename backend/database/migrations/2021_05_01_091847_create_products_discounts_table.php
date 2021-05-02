<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateProductsDiscountsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('products_discounts', function (Blueprint $table) {
            $table->integer('id', true);
            $table->float('discount', 3, 2);
            $table->date('start_date_discount');
            $table->date('end_date_discount');
            $table->timestamps();
        });
        Schema::table('products_discounts', function (Blueprint $table) {
            $table->integer('products_id');


            $table->foreign('products_id')->references('id')->on('products');
            $table->integer('create_by');
            $table->integer('update_by');

            $table->foreign('create_by')->references('id')->on('users');
            $table->foreign('update_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('products_discounts');
    }
}
