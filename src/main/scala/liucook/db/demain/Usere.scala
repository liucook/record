package liucook.db.demain

import slick.lifted.Tag
import slick.jdbc.MySQLProfile.api._
import slick.relational.RelationalProfile.ColumnOption.Default
import slick.sql.SqlProfile.ColumnOption.SqlType

/**
  * Created by terje on 2017/8/20.
  */
case class Usere(id:Int,name:String,age:Int,address:String)
class UsereMap(tag:Tag) extends Table[Usere](tag,"usere"){

  def id = column[Int]("ID",O.PrimaryKey,O.AutoInc)
  def name = column[String]("name")
  def age = column[Int]("age")
  def address = column[String]("address")

  def *  = (id,name,age,address) <> (from , to)


  def to(user: Usere): Option[(Int,String,Int,String)] = {
    Some(user.id,user.name,user.age,user.address)
  }

  def from(tupled:(Int,String,Int,String)):Usere={
    Usere(tupled._1,tupled._2,tupled._3,tupled._4)
  }
}