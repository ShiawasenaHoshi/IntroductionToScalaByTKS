val list1 = List(1, 3, 5, 7)
val list2 = List(1, 1, 2, 4, 6, 8)
val list3 = List(1, 3, 5, 8, 10, 12, 14)

for {
  l1 <- list1
  l2 <- list2
  l3 <- list3
  tup = (l1, l2)
  result <- List(tup) if  l1 != l2 && tup._1 * tup._2 == l3
} yield println(result)