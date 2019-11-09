package container;

import org.lwjgl.opengl.GL11;

import kekztech.KekzCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import tileentities.TE_ItemDistributionNode;

public class Gui_ItemDistributionNode extends GuiContainer {
	
	private final ResourceLocation texture = new ResourceLocation(KekzCore.MODID, "textures/gui/ItemDistributionNode.png");
	
	private final InventoryPlayer inventory;
	private final TE_ItemDistributionNode te;
	
	public Gui_ItemDistributionNode(TE_ItemDistributionNode te, EntityPlayer player) {
		super(new Container_ItemDistributionNode(te, player));
		inventory = player.inventory;
		this.te = te;
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		
		final int x = (super.width - super.xSize) / 2;
		final int y = (super.height - super.ySize) / 2;
		
		super.drawTexturedModalRect(x, y, 0, 0, super.xSize, super.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int p1, int p2) {
		super.fontRendererObj.drawString(
				I18n.format(te.getInventoryName()),
				(super.xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(te.getInventoryName())) / 2),
				6, 4210752, false);
		super.fontRendererObj.drawString(
				I18n.format(inventory.getInventoryName()), 8, super.ySize - 96 + 2, 4210752);
	}
}
