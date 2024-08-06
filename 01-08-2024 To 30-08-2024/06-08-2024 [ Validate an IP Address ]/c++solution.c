class Solution {
public:
    bool isValid(std::string str) {
        std::vector<std::string> parts;
        std::string part;
        std::istringstream ss(str);

        while (std::getline(ss, part, '.')) {
            parts.push_back(part);
        }

        if (parts.size() != 4) return false;

        for (const auto& part : parts) {
    
            if (part.empty() || !isNumeric(part)) return false;

            int num = std::stoi(part);
            if (num < 0 || num > 255) return false;

            if (part.size() > 1 && part[0] == '0') return false;
        }

        return true;
    }

private:
    bool isNumeric(const std::string& str) {
        for (char c : str) {
            if (!isdigit(c)) return false;
        }
        return true;
    }
};
