#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

// Structure to represent an edge between two cities
struct Edge {
    int destination;
    int weight;
};

// Function to add an edge to the graph
void addEdge(vector<vector<Edge>>& graph, int source, int destination, int weight) {
    graph[source].push_back({destination, weight});
    graph[destination].push_back({source, weight}); 
}

// Function to find the minimum spanning tree using Prim's algorithm
int primMST(vector<vector<Edge>>& graph, int startCity) {
    int n = graph.size();
    vector<bool> inMST(n, false);  
    vector<int> key(n, numeric_limits<int>::max()); 
    vector<int> parent(n, -1);
    key[startCity] = 0; 
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, startCity});

    int totalWeight = 0; 

    while (!pq.empty()) {
        int currentCity = pq.top().second;
        pq.pop();

        if (inMST[currentCity]) continue;

        // Mark the city as included in the MST
        inMST[currentCity] = true;
        totalWeight += key[currentCity];

        // Check all adjacent cities
        for (const Edge& edge : graph[currentCity]) {
            int nextCity = edge.destination;
            int weight = edge.weight;

           
            if (!inMST[nextCity] && weight < key[nextCity]) {
                key[nextCity] = weight;
                pq.push({weight, nextCity});
                parent[nextCity] = currentCity;
            }
        }
    }

    // Output the MST edges
    cout << "Edges in the Minimum Spanning Tree (MST):\n";
    for (int i = 1; i < n; i++) {
        if (parent[i] != -1)
            cout << "City " << parent[i] << " - City " << i << " (Distance: " << key[i] << ")\n";
    }

    return totalWeight;
}

int main() {
    int numCities = 6;  
    vector<vector<Edge>> graph(numCities);

    // Add edges between cities (undirected graph)
    addEdge(graph, 0, 1, 4);
    addEdge(graph, 0, 2, 6);
    addEdge(graph, 1, 2, 6);
    addEdge(graph, 1, 3, 3);
    addEdge(graph, 1, 4, 2);
    addEdge(graph, 2, 3, 1);
    addEdge(graph, 3, 4, 5);
    addEdge(graph, 3, 5, 7);
    addEdge(graph, 4, 5, 3);

    int startCity = 0;  

    
    int totalWeight = primMST(graph, startCity);

    cout << "Total weight of the Minimum Spanning Tree: " << totalWeight << endl;

    return 0;
}
