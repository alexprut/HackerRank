rev [] = []
rev (x:xs) = (rev xs) ++ [x]
