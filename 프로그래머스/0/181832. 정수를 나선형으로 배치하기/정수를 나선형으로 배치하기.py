def solution(n):
    answer = [[0 for _ in range(n)] for _ in range(n)]
    
    x = 0
    y = 0
    
    num = 1
    pos = "right"
    
    answer[x][y] = 1;
    
    while num != n**2:
        if pos == "right":
            if y + 1 < n and answer[x][y+1] == 0:
                num +=1
                answer[x][y+1] = num
                y+=1
            else: 
                pos = "bottom"
        
        elif pos == "bottom":
            if x + 1 < n and answer[x+1][y] == 0:
                num +=1
                answer[x+1][y] = num  
                x+=1
            else : 
                pos = "left"
            
        elif pos == "left" :
            if y - 1 >= 0 and answer[x][y-1] == 0  :
                num +=1
                answer[x][y-1] = num   
                y -=1
            else : 
                pos = "up"
         
        elif pos == "up" :
            if x - 1 >= 0 and answer[x-1][y] == 0  :
                num +=1
                answer[x-1][y] = num
                x-=1
            else : 
                pos = "right"
            
    return answer