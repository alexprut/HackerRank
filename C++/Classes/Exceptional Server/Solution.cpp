		try {
          cout << Server::compute(A, B) << "\n";
        } catch (const std::bad_alloc& e) {
            cout << "Not enough memory\n";
        } catch (const std::exception& e) {
            cout << "Exception: " << e.what() << "\n";
        } catch (...) {
            cout << "Other Exception\n";
        }
