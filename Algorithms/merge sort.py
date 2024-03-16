def merge(b,c,a):
    i=0
    j=0
    k=0
    while i<len(b) and j<len(c):
        if b[i]<c[j]:
            a[k]=b[i]
            
            k=k+1
            i=i+1
        else:
            a[k]=c[j]
            
            k=k+1
            j=j+1
    while i<len(b):
        a[k]=b[i]
        i=i+1
        k=k+1
    while j<len(c):
        a[k]=c[j]
        k=k+1
        j=j+1
   
    
def mergeSort(a):
    
    # Please add your code here
    if len(a)==0 or len(a)==1:
        return
    mid=len(a)//2
    b=a[0:mid]
    c=a[mid:]
    mergeSort(b)
    mergeSort(c)
    merge(b,c,a)
    
    pass

# Main
n=int(input())
a=list(int(i) for i in input().strip().split(' '))
mergeSort(a)
print(*a)
