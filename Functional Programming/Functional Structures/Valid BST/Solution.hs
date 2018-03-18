data Tree a = EmptyNode | Node a (Tree a) (Tree a) deriving (Eq, Show, Read, Ord)

treeInsert :: (Ord a) => Tree a -> a -> Tree a
treeInsert EmptyNode x = Node x EmptyNode EmptyNode
treeInsert (Node a leftTree rightTree) x = if x <= a
  then (Node a (treeInsert leftTree x) rightTree)
  else (Node a leftTree (treeInsert rightTree x))

preOrder :: Tree a -> [a]
preOrder EmptyNode = []
preOrder (Node a leftTree rightTree) = [a] ++ (preOrder leftTree) ++ (preOrder rightTree)

main = do
    n <- getLine
    mapM_ (\_ -> do
      c <- getLine
      list <- getLine
      let l = map (\x -> read x :: Int) (words list)
          o = preOrder (foldl (\acc x -> treeInsert acc x) EmptyNode l)
      if o == l
        then do putStrLn "YES"
        else do putStrLn "NO"
      return ()
      ) [1..(read n :: Int)]
