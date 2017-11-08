module Main where

main = do
  input <- getLine
  print . uncurry gcd . listToTuple . convertToInt . words $ input
 where
  listToTuple (x:xs:_) = (x,xs)
  convertToInt = map (read :: String -> Int)
