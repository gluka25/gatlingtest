package sushishop

import books.books_1801_caad7f.{BookServiceGrpc, Empty}
import com.github.phisgr.gatling.grpc.Predef._
import io.gatling.core.Predef._
import com.github.phisgr.gatling.pb._
import io.gatling.core.structure.ChainBuilder


object GrpcMethods {


  val grpcList = exec(grpc("grpcList")
    .rpc(BookServiceGrpc.METHOD_LIST)
    .payload(Empty())
    )

}
