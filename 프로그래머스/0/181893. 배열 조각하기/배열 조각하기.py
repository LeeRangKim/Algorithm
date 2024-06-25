def solution(arr, query):
    
    for i in range(len(query)):
        if i % 2 == 1:
            arr = arr[query[i]:len(arr)]

        else :
            arr = arr[0:query[i]+1]
    return arr