#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Structure to represent an edge
struct Edge {
    int source, destination, weight;
};

// Function to find the parent of a node in the disjoint-set
int findParent(vector<int>& parent, int vertex) {
    if (parent[vertex] != vertex) {
        parent[vertex] = findParent(parent, parent[vertex]); // Path compression
    }
    return parent[vertex];
}

// Function to union two subsets into a single subset
void unionSets(vector<int>& parent, vector<int>& rank, int root1, int root2) {
    if (rank[root1] < rank[root2]) {
        parent[root1] = root2;
    } else if (rank[root1] > rank[root2]) {
        parent[root2] = root1;
    } else {
        parent[root2] = root1;
        rank[root1]++;
    }
}

// Function to implement Kruskal's algorithm to find the MST
vector<Edge> kruskalMST(vector<Edge>& edges, int numVertices) {
    vector<Edge> mst;
    vector<int> parent(numVertices);
    vector<int> rank(numVertices, 0);

    // Initialize each vertex to be its own parent (disjoint sets)
    for (int i = 0; i < numVertices; i++) {
        parent[i] = i;
    }

    // Sort all edges by their weight
    sort(edges.begin(), edges.end(), [](Edge a, Edge b) {
        return a.weight < b.weight;
    });

    // Iterate through the sorted edges and add them to the MST if they don't form a cycle
    for (Edge& edge : edges) {
        int root1 = findParent(parent, edge.source);
        int root2 = findParent(parent, edge.destination);

        if (root1 != root2) { // If including this edge doesn't form a cycle
            mst.push_back(edge);
            unionSets(parent, rank, root1, root2);
        }
    }

    return mst;
}

int main() {
    int numVertices = 7; // Number of cities
    vector<Edge> edges;

    // Example: Add edges between cities
    edges.push_back({0, 1, 10});
    edges.push_back({0, 2, 15});
    edges.push_back({1, 3, 12});
    edges.push_back({2, 3, 10});
    edges.push_back({3, 4, 2});
    edges.push_back({4, 5, 5});
    edges.push_back({5, 6, 10});

    vector<Edge> mst = kruskalMST(edges, numVertices);

    cout << "Edges in the Minimum Spanning Tree:" << endl;
    for (const Edge& edge : mst) {
        cout << edge.source << " -- " << edge.destination << " == " << edge.weight << endl;
    }

    return 0;
}
