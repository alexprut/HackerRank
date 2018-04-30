import qualified Data.List as List
import qualified GHC.Arr as Array

incrementalAcc _ [] = []
incrementalAcc acc (x:xs) = acc' : incrementalAcc acc' xs
  where acc' = acc + x

binarySearch xs value low high
   | high < low = -1
   | low == high && low == mid && high == mid = if xs Array.! mid >= value then (mid + 1) else -1
   | xs Array.! mid < value = binarySearch xs value (mid + 1) high
   | xs Array.! mid > value = binarySearch xs value low mid
   | otherwise = (mid + 1)
   where
   mid = low + ((high - low) `div` 2)

outputString optimizedNumbers [] _ q = []
outputString optimizedNumbers (x:xs) max q =
  (if x > max then -1 else (binarySearch optimizedNumbers x 0 q)) : (outputString optimizedNumbers xs max q)

main = do
  _ <- getLine
  numbers <- fmap (map (read :: String -> Int) . words) getLine
  let optimizedNumbers = Array.listArray (0, (length numbers) - 1) (incrementalAcc 0 $ List.sortBy (\x y -> if x <= y then GT else LT) numbers)
  q <- fmap (read :: String -> Int) getLine
  qNumbers <- fmap (map (read :: String -> Int) . words) getContents
  let max = optimizedNumbers Array.! ((length numbers) - 1)
  mapM_ (\x -> do print x) $ outputString optimizedNumbers qNumbers max ((length numbers) - 1)
