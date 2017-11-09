#define INF INT8_MAX
#define FUNCTION(name,operator) void name(int &current, int candidate) {!(current operator candidate) ? current = candidate : false;}
#define io(v) cin>>v
#define toStr(str) #str
#define foreach(v, i) for (int i = 0; i < v.size(); ++i)
