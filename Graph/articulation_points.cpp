function find_articulation_points(adj[][], V)
    count = 0
    for i = 0 to V
        visited[i] = false
    initial_val = 0 
    for i = 0 to V
        if visited[i] == false
            DFS(adj, V, visited, i)
            initial_val = initial_val+1

    for i=0 to V
        for j = 0 to V
            visited[j] = false
            copy[j] = adj[i][j]
            adj[i][j]=adj[j][i]=0

        nval = 0
        for j= 0 to V
            if visited[j] == false AND j != i
                nval = nval + 1
                DFS(adj, n, visited, j)
        if nval > initial_val
            count = count + 1
        for j= 0 to V
            adj[i][j] = adj[j][i] = copy[j]
    return count
