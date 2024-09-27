#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string> &paths) {
        unordered_map<string, vector<string> > contentPathsMap;

        vector<string> splitResult;
        for (const auto &path : paths) {
            splitResult.clear();
            spiltString(path, splitResult, ' ');
            if (splitResult.size() <= 1) {
                continue;
            }

            for (int i = 1; i < splitResult.size(); ++i) {
                auto &str = splitResult[i];
                auto pos1 = str.find('(');
                if (pos1 == string::npos) {
                    continue;
                }
                auto pos2 = str.find(')');
                if (pos2 == string::npos) {
                    continue;
                }

                if (pos1 >= pos2) {
                    continue;
                }

                string content = str.substr(pos1 + 1, pos2 - pos1 - 1);
                string filePath = splitResult[0] + '/' + str.substr(0, pos1);

                auto iter = contentPathsMap.find(content);
                if (iter == contentPathsMap.end()) {
                    contentPathsMap[content] = vector<string>();
                    contentPathsMap[content].emplace_back(filePath);
                } else {
                    iter->second.emplace_back(filePath);
                }
            }
        }

        vector<vector<string>> result;
        for (auto &iter : contentPathsMap) {
            result.emplace_back(iter.second);
        }
        return result;
    }

    void spiltString(const string &str, vector<string> &result, char separator) {
        size_t posStart = 0;
        size_t pos = str.find(separator);
        while (pos != string::npos) {
            result.emplace_back(str.substr(posStart, pos - posStart));
            posStart = pos + 1;
            pos = str.find(separator, posStart);
        }

        result.emplace_back(str.substr(posStart));
    }
};