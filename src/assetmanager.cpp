#include "assetmanager.h"
#include <unistd.h>

AssetManager::AssetManager() {
    loadTexture("bg", "resources/bg.png");
    loadTexture("pillar", "resources/pillar.png");

    textures["bg"].setRepeated(true);

    char cwd[FILENAME_MAX];
    getcwd(cwd, sizeof(cwd));
    std::cout << cwd << std::endl;
}

AssetManager::~AssetManager() {

}

bool AssetManager::loadTexture(const std::string& name, const std::string& filepath) {
    sf::Texture tex;
    if(!tex.loadFromFile(filepath)) {
        std::cout << "Failed to load texture with filepath " << filepath << std::endl;
        return false;
    }

    textures[name] = tex;
    return true;
}

sf::Sprite AssetManager::getSprite(const std::string& texture) {
    return sf::Sprite(textures[texture]); 
}

sf::Texture AssetManager::getTexture(const std::string& texture) {
    return textures[texture];
}

