import Control.Applicative
import Control.Monad
import System.IO

eee :: Double -> Double -> Double
eee 1 x = x + 1
eee n x = ((x**n) / (product [1..n])) + (eee (n-1) x)

main :: IO ()
main = do
    n_temp <- getLine
    let n = read n_temp :: Int
    forM_ [1..n] $ \a0  -> do
        x_temp <- getLine
        let x = read x_temp :: Double
        print (eee 9 x)


getMultipleLines :: Int -> IO [String]

getMultipleLines n
    | n <= 0 = return []
    | otherwise = do
        x <- getLine
        xs <- getMultipleLines (n-1)
        let ret = (x:xs)
        return ret

