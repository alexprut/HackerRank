import Data.List
import Data.Foldable

-- Data type
data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq)

-- Binary Tree operations
inOrderVisit EmptyTree = []
inOrderVisit (Node a l r) = (inOrderVisit l) ++ [a] ++ (inOrderVisit r)

singletonNode (-1) = EmptyTree
singletonNode n = Node n EmptyTree EmptyTree

insertNode EmptyTree _ = EmptyTree
insertNode (Node n left right) (search, l, r) = if n == search
  then (Node n (singletonNode l) (singletonNode r))
  else (Node n (insertNode left (search, l,r)) (insertNode right (search, l,r)))

addIndexNodes [] _ = []
addIndexNodes (x:xs) counter = [(
    counter, ((read :: String -> Int) (head t)), ((read :: String -> Int) (last t))
  )] ++ (addIndexNodes xs (counter + 1))
  where t = (words x)


swapping EmptyTree _ _ = EmptyTree
swapping (Node n left right) k depth = if (mod depth k) == 0
  then (Node n (swapping right k (depth + 1)) (swapping left k (depth + 1)))
  else (Node n (swapping left k (depth + 1)) (swapping right k (depth + 1)))

swapit x k = swapping x k 1

formString [] = []
formString (x:xs) = (show x) ++ " " ++ (formString xs)


-- I/O
main = do
  input <- getContents
  let inputLines = lines input
  let n = (read :: String -> Int) $ head inputLines
  let nodes = addIndexNodes (take n (tail inputLines)) 1
  let (_, ks) = splitAt (n+1) (tail inputLines)
  let tree = foldl insertNode (singletonNode 1) nodes
  let results = map (\x -> inOrderVisit (swapit tree (read x))) ks
  foldlM (\x y -> do
      let newTree = (swapit x (read y))
      putStrLn $ formString $ inOrderVisit newTree
      return newTree
    ) tree ks
