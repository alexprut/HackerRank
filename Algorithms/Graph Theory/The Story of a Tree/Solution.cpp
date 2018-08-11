#include<bits/stdc++.h>
using namespace std;
#define MAX     100000
#define D(x)    cout << #x " = " << (x) << endl

vector<int> edge[MAX+7];
int csum[MAX+7], st[MAX+7], ed[MAX+7], parent[MAX+7], indx;


void dfs(int idx, int par = -1)
{
    parent[idx] = par;

    indx++;
    st[idx] = indx;


    for(auto x : edge[idx]){
        if(x == par) continue;
        dfs(x, idx);
    }

    ed[idx] = indx;
}

int main()
{
    int i, j, k, t, cs, n, u, v, q;
    int valid;

    scanf("%d", &t);
    while(t--)
    {
        memset(csum, 0, sizeof(csum));
        valid = indx = 0;

        scanf("%d", &n);
        for(i = 1; i < n; i++)
        {
            scanf("%d %d", &u, &v);
            edge[u].push_back(v);
            edge[v].push_back(u);
        }

        int root = 1;
        dfs(root);

        scanf("%d %d", &q, &k);
        for(i = 1; i <= q; i++)
        {
            scanf("%d %d", &u, &v);
            if(parent[v] == u){
                csum[st[root]]++;
                csum[ed[root]+1]--;

                csum[st[v]]--;
                csum[ed[v]+1]++;
            }
            else{
                csum[st[u]]++;
                csum[ed[u]+1]--;
            }
        }


        for(i = st[root]; i <= ed[root]; i++)
        {
            csum[i] += csum[i - 1];
            if(csum[i] >= k)
                valid++;
        }

        int g = __gcd(valid, n);

        printf("%d/%d\n", valid / g, n / g);

        for(i = 1; i <= n; i++)
            edge[i].clear();
    }
    return 0;
}
