#pragma once
#ifndef ASSET_MANAGER_H
#define ASSET_MANAGER_H

#include <iostream>
#include <unordered_map>
#include <string>

#include <SFML/Graphics.hpp>

class AssetManager {
    private:
        std::unordered_map<std::string, sf::Texture> textures;
        bool loadTexture(const std::string& name, const std::string& filepath);

    public:
        AssetManager();
        ~AssetManager();

        sf::Sprite getSprite(const std::string& texture);
        sf::Texture getTexture(const std::string& texture);

};

#endif

