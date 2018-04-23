import qualified Data.Map as Map
import qualified Data.List as List

data PNumber = PNumber {
  number :: Int,
  position :: Int,
  counter :: Int
} deriving (Eq, Ord, Show)

toPNumbers xs = createPNumbers xs 0
createPNumbers [] _ = []
createPNumbers (x:xs) position = (PNumber x position 1) : (createPNumbers xs (position + 1))

countPNumbers xs = foldl (\acc x -> insertPNumber acc x) Map.empty xs

insertPNumber acc x = case (Map.lookup (number x) acc) of
  Just pNumber -> Map.insert (number pNumber) (PNumber (number pNumber) (position pNumber) ((counter pNumber) + 1)) acc
  Nothing -> Map.insert (number x) x acc

filterPNumbers k xs = List.filter (\x -> (counter x) >= k) ls
  where ls = Map.elems xs

sortPNumbers xs = List.sortBy (\x y -> if (position x) < (position y) then LT else GT) xs

printPNumbers [] = do putStrLn "-1"
printPNumbers xs = do
  mapM_ (\x ->
    putStr $ show (number x) ++ " "
    ) xs
  putStrLn ""

main = do
  q <- fmap (read :: String -> Int) getLine
  mapM_ (\_ -> do
    nk <- fmap (map (read :: String -> Int) . words) getLine
    let n = nk !! 0
    let k = nk !! 1
    numbers <- fmap (map (read :: String -> Int) . words) getLine
    printPNumbers $ sortPNumbers $ filterPNumbers k $ countPNumbers $ toPNumbers numbers
    ) [1..q]
