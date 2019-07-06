val nums = List(2, 5, 1, 7, 4)

val nums2 = nums.map(x => x * 2)
val numsCompr =
  for (x <- nums)
    yield x * 2

val numsFlatMap =
  nums.flatMap(x => 1 to x)
    .map(y => y * 2)
val numsFlatMapCompr =
  for (x <- nums; y <- 1 to x)
    yield y * 2
val numsFlatMapCompr2 =
  for {
    x <- nums
    y <- 1 to x
  } yield y * 2

val numsFlatMapFilter =
  nums.flatMap(x => (1 to x).withFilter(y => y > 3).map(y => y * 2))
val numsFlatMapFilterCompr =
  for {
    x <- nums
    y <- 1 to x if y > 3
  } yield y * 2

val numsManyOps =
  nums.flatMap(x =>
    (1 to x)
      .withFilter(y => y > 3)
      .map(y => (y, y * 2))
    .flatMap{ case (y, y2) =>
      nums
        .withFilter(z => z < y2)
        .map(z => z + y2 - y)
    })
val numsManyOpsCompr =
  for {
    x <- nums
    y <- 1 to x if y > 3
    y2 = y * 2
    z <- nums if z < y2
  } yield z + y2 - y