package miscutil.core.item.base;

import java.util.List;

import miscutil.core.lib.CORE;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CoreItem extends Item
{

	private final EnumRarity rarity;
	private final EnumChatFormatting descColour;
	private final String itemDescription;
	private final boolean hasEffect;

	//0
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab)
	{
		this(unlocalizedName, creativeTab, 64, 0); //Calls 3
	}
	//1
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize)
	{
		this(unlocalizedName, creativeTab, stackSize, 0); //Calls 3
	}
	//2
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize, String description)
	{
		this(unlocalizedName, creativeTab, stackSize, 0, description); //Calls 4
	}	
	//3
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize, int maxDmg)
	{
		this(unlocalizedName, creativeTab, stackSize, maxDmg, ""); //Calls 4
	}
	//4 //Not Rare + basic tooltip
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize, int maxDmg, String description)
	{
		this(unlocalizedName, creativeTab, stackSize, maxDmg, EnumRarity.common, description, EnumChatFormatting.GRAY, false); //Calls 4.5
	}
	//4.5
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize, int maxDmg, String description, EnumChatFormatting colour)
	{
		this(unlocalizedName, creativeTab, stackSize, maxDmg, EnumRarity.common, description, colour, false); //Calls 5
	}

	//4.75
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize, int maxDmg, String description, EnumRarity rarity)
	{
		this(unlocalizedName, creativeTab, stackSize, maxDmg, rarity, description, EnumChatFormatting.GRAY, false); //Calls 5
	}

	//5	
	public CoreItem(String unlocalizedName, CreativeTabs creativeTab, int stackSize, int maxDmg, EnumRarity regRarity, String description, EnumChatFormatting colour, boolean Effect)
	{
		setUnlocalizedName(unlocalizedName);
		setTextureName(CORE.MODID + ":" + unlocalizedName);
		setCreativeTab(creativeTab);
		setMaxStackSize(stackSize);
		setMaxDamage(maxDmg);
		this.rarity = regRarity;
		this.itemDescription = description;
		this.descColour = colour;
		this.hasEffect = Effect;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer aPlayer, List list, boolean bool) {
		list.add(descColour+itemDescription);
		super.addInformation(stack, aPlayer, list, bool);
	}	

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return rarity;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return hasEffect;
	}
}