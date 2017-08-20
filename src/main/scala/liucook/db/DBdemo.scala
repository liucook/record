package liucook.db

import com.typesafe.config.ConfigFactory
import liucook.db.demain.{Usere, UsereMap}
import slick.jdbc.MySQLProfile.api._
/**
  * Created by terje on 2017/8/20.
  */
object DBdemo extends App{
  val factory=ConfigFactory.load("mysql.conf")
  val db=Database.forConfig("mysql",factory)

  val user=TableQuery[UsereMap]
  val action=DBIO.seq(
    user.+=(Usere(1,"abc",31,"yuyuyu"))
  )

  db.run(action)

//  db.close()
//  Thread.sleep(2000)
  println("--------------------")
  val action01=DBIO.seq(
    user.+=(Usere(1,"abc",31,"hhhhhhh"))
  )

//  for(i <- 1 to 50){
    db.run(action01)
//  }

  Thread.sleep(22000)
  db.close()

}
