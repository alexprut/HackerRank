class LRUCache: Cache {
 public:
  LRUCache(int l) {
    cp = l;
    tail = NULL;
    head = NULL;
    mp = {};
  }
  virtual void set(int k, int v) {
    auto it = mp.find(k);
    if (it == mp.end()) {
      Node *node = new Node(k, v);
      if (cp == 0) {
        node->next = head;
        head->prev = node;
        head = node;
        Node *tmp = tail;
        mp.erase(tmp->key);
        tail = tail->prev;
        delete tmp;
      } else {
        cp--;
        if (head == NULL) {
          head = node;
          tail = node;
        } else {
          node->next = head;
          head->prev = node;
          head = node;
        }
      }
      mp[k] = node;
    } else {
      Node *tmp = it->second;
      if (tmp != head) {
        if (tmp == tail) {
          tail = tmp->prev;
          tmp->prev->next = NULL;
          tmp->prev = NULL;
          tmp->next = head;
          head->prev = tmp;
          head = tmp;
        } else {
          tmp->prev->next = tmp->next;
          tmp->next->prev = tmp->prev;
          tmp->prev = NULL;
          tmp->next = head;
          head->prev = tmp;
          head = tmp;
        }
      }
      head->value = v;
    }
  }
  virtual int get(int k) {
    auto it = mp.find(k);
    if (it != mp.end()) {
      return it->second->value;
    }
    return -1;
  }
};
