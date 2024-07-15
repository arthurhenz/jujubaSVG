package com.gabrielbmoro.jujubasvg.core.commander

import com.gabrielbmoro.jujubasvg.model.NodeCoordinate

public sealed class Command {

    /**
     * Update the background color of a node.
     * @param id The id of the node.
     * @param hexColor The color in hex.
     */
    public data class UpdateBackgroundColor(
        val id: String,
        val hexColor: String,
    ) : Command()

    /**
     * Update the stroke color of a node.
     * @param id The id of the node.
     * @param hexColor The color in hex.
     */
    public data class UpdateStrokeColor(
        val id: String,
        val hexColor: String,
    ) : Command()

    /**
     * Update the stroke width of a node.
     * @param id The id of the node.
     * @param width The width in pixels.
     */
    public data class UpdateStrokeWidth(
        val id: String,
        val width: Int,
    ) : Command()

    /**
     * Remove a node.
     * @param id The id of the node.
     */
    public data class RemoveNode(
        val id: String,
    ) : Command()

    /**
     * Update the root background color.
     */
    public data class UpdateRootBackgroundColor(
        val hexColor: String,
    ) : Command()

    /**
     * Add a rounded image into the same parent of the elementId.
     * @param elementId The id of the element, the rounded image will
     * be added at the same level of this elementId, so they will have the same parent node.
     * @param imageId The id of the new element to be added
     * @param imageUrl The url where the image is available
     * @param width The width of the image in pixels
     * @param height The height of the image in pixels
     * @param coordinate The coordinates where the image will be added
     */
    public data class AddRoundedImage(
        val elementId: String,
        val imageId: String,
        val imageUrl: String,
        val width: Int,
        val height: Int,
        val coordinate: NodeCoordinate
    ) : Command()
}