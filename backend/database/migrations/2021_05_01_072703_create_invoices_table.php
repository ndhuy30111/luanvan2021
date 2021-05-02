<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateInvoicesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('invoices', function (Blueprint $table) {
            $table->integer('id', true);
            $table->string('address', 100)->nullable();
            $table->integer('numberphone')->nullable();
            $table->date('bill_date')->nullable();
            $table->string('note')->nullable();
            $table->tinyInteger('status')->default('1');
            $table->timestamps();
        });
        Schema::table('invoices', function (Blueprint $table) {
            $table->integer('user_id');
            $table->integer('create_by');
            $table->integer('update_by');
            $table->integer('bill_by');

            $table->foreign('user_id')->references('id')->on('users');
            $table->foreign('create_by')->references('id')->on('users');
            $table->foreign('update_by')->references('id')->on('users');
            $table->foreign('bill_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('invoices');
    }
}
